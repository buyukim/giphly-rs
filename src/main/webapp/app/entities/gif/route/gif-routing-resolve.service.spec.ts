jest.mock('@angular/router');

import { TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of } from 'rxjs';

import { IGif, Gif } from '../gif.model';
import { GifService } from '../service/gif.service';

import { GifRoutingResolveService } from './gif-routing-resolve.service';

describe('Service Tests', () => {
  describe('Gif routing resolve service', () => {
    let mockRouter: Router;
    let mockActivatedRouteSnapshot: ActivatedRouteSnapshot;
    let routingResolveService: GifRoutingResolveService;
    let service: GifService;
    let resultGif: IGif | undefined;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [Router, ActivatedRouteSnapshot],
      });
      mockRouter = TestBed.inject(Router);
      mockActivatedRouteSnapshot = TestBed.inject(ActivatedRouteSnapshot);
      routingResolveService = TestBed.inject(GifRoutingResolveService);
      service = TestBed.inject(GifService);
      resultGif = undefined;
    });

    describe('resolve', () => {
      it('should return IGif returned by find', () => {
        // GIVEN
        service.find = jest.fn(id => of(new HttpResponse({ body: { id } })));
        mockActivatedRouteSnapshot.params = { id: 123 };

        // WHEN
        routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
          resultGif = result;
        });

        // THEN
        expect(service.find).toBeCalledWith(123);
        expect(resultGif).toEqual({ id: 123 });
      });

      it('should return new IGif if id is not provided', () => {
        // GIVEN
        service.find = jest.fn();
        mockActivatedRouteSnapshot.params = {};

        // WHEN
        routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
          resultGif = result;
        });

        // THEN
        expect(service.find).not.toBeCalled();
        expect(resultGif).toEqual(new Gif());
      });

      it('should route to 404 page if data not found in server', () => {
        // GIVEN
        spyOn(service, 'find').and.returnValue(of(new HttpResponse({ body: null })));
        mockActivatedRouteSnapshot.params = { id: 123 };

        // WHEN
        routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
          resultGif = result;
        });

        // THEN
        expect(service.find).toBeCalledWith(123);
        expect(resultGif).toEqual(undefined);
        expect(mockRouter.navigate).toHaveBeenCalledWith(['404']);
      });
    });
  });
});