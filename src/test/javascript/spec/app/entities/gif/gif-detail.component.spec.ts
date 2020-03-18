import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GiphlyTestModule } from '../../../test.module';
import { GifDetailComponent } from 'app/entities/gif/gif-detail.component';
import { Gif } from 'app/shared/model/gif.model';

describe('Component Tests', () => {
  describe('Gif Management Detail Component', () => {
    let comp: GifDetailComponent;
    let fixture: ComponentFixture<GifDetailComponent>;
    const route = ({ data: of({ gif: new Gif(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GiphlyTestModule],
        declarations: [GifDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
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
        expect(comp.gif).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
