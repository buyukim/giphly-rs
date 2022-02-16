import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { GiphlyTestModule } from '../../../test.module';
import { GifComponent } from 'app/entities/gif/gif.component';
import { GifService } from 'app/entities/gif/gif.service';
import { Gif } from 'app/shared/model/gif.model';

describe('Component Tests', () => {
  describe('Gif Management Component', () => {
    let comp: GifComponent;
    let fixture: ComponentFixture<GifComponent>;
    let service: GifService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GiphlyTestModule],
        declarations: [GifComponent],
      })
        .overrideTemplate(GifComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(GifComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(GifService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Gif(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.gifs && comp.gifs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
