import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GifDetailComponent } from './gif-detail.component';

describe('Component Tests', () => {
  describe('Gif Management Detail Component', () => {
    let comp: GifDetailComponent;
    let fixture: ComponentFixture<GifDetailComponent>;

    beforeEach(() => {
      TestBed.configureTestingModule({
        declarations: [GifDetailComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: { data: of({ gif: { id: 123 } }) },
          },
        ],
      })
        .overrideTemplate(GifDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(GifDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load gif on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.gif).toEqual(expect.objectContaining({ id: 123 }));
      });
    });
  });
});
