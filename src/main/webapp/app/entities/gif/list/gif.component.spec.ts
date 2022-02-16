import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

import { GifService } from '../service/gif.service';

import { GifComponent } from './gif.component';

describe('Component Tests', () => {
  describe('Gif Management Component', () => {
    let comp: GifComponent;
    let fixture: ComponentFixture<GifComponent>;
    let service: GifService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [GifComponent],
      })
        .overrideTemplate(GifComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(GifComponent);
      comp = fixture.componentInstance;
      service = TestBed.inject(GifService);

      const headers = new HttpHeaders().append('link', 'link;link');
      jest.spyOn(service, 'query').mockReturnValue(
        of(
          new HttpResponse({
            body: [{ id: 123 }],
            headers,
          })
        )
      );
    });

    it('Should call load all on init', () => {
      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.gifs?.[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
