jest.mock('@angular/router');

import { TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of } from 'rxjs';

import { IFavorite, Favorite } from '../favorite.model';
import { FavoriteService } from '../service/favorite.service';

import { FavoriteRoutingResolveService } from './favorite-routing-resolve.service';

describe('Service Tests', () => {
  describe('Favorite routing resolve service', () => {
    let mockRouter: Router;
    let mockActivatedRouteSnapshot: ActivatedRouteSnapshot;
    let routingResolveService: FavoriteRoutingResolveService;
    let service: FavoriteService;
    let resultFavorite: IFavorite | undefined;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [Router, ActivatedRouteSnapshot],
      });
      mockRouter = TestBed.inject(Router);
      mockActivatedRouteSnapshot = TestBed.inject(ActivatedRouteSnapshot);
      routingResolveService = TestBed.inject(FavoriteRoutingResolveService);
      service = TestBed.inject(FavoriteService);
      resultFavorite = undefined;
    });

    describe('resolve', () => {
      it('should return IFavorite returned by find', () => {
        // GIVEN
        service.find = jest.fn(id => of(new HttpResponse({ body: { id } })));
        mockActivatedRouteSnapshot.params = { id: 123 };

        // WHEN
        routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
          resultFavorite = result;
        });

        // THEN
        expect(service.find).toBeCalledWith(123);
        expect(resultFavorite).toEqual({ id: 123 });
      });

      it('should return new IFavorite if id is not provided', () => {
        // GIVEN
        service.find = jest.fn();
        mockActivatedRouteSnapshot.params = {};

        // WHEN
        routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
          resultFavorite = result;
        });

        // THEN
        expect(service.find).not.toBeCalled();
        expect(resultFavorite).toEqual(new Favorite());
      });

      it('should route to 404 page if data not found in server', () => {
        // GIVEN
        jest.spyOn(service, 'find').mockReturnValue(of(new HttpResponse({ body: null as unknown as Favorite })));
        mockActivatedRouteSnapshot.params = { id: 123 };

        // WHEN
        routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
          resultFavorite = result;
        });

        // THEN
        expect(service.find).toBeCalledWith(123);
        expect(resultFavorite).toEqual(undefined);
        expect(mockRouter.navigate).toHaveBeenCalledWith(['404']);
      });
    });
  });
});
