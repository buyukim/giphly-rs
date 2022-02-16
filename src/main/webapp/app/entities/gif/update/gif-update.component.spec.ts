jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { GifService } from '../service/gif.service';
import { IGif, Gif } from '../gif.model';

import { GifUpdateComponent } from './gif-update.component';

describe('Component Tests', () => {
  describe('Gif Management Update Component', () => {
    let comp: GifUpdateComponent;
    let fixture: ComponentFixture<GifUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let gifService: GifService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [GifUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(GifUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(GifUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      gifService = TestBed.inject(GifService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should update editForm', () => {
        const gif: IGif = { id: 456 };

        activatedRoute.data = of({ gif });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(gif));
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Gif>>();
        const gif = { id: 123 };
        jest.spyOn(gifService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ gif });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: gif }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(gifService.update).toHaveBeenCalledWith(gif);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Gif>>();
        const gif = new Gif();
        jest.spyOn(gifService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ gif });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: gif }));
        saveSubject.complete();

        // THEN
        expect(gifService.create).toHaveBeenCalledWith(gif);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Gif>>();
        const gif = { id: 123 };
        jest.spyOn(gifService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ gif });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(gifService.update).toHaveBeenCalledWith(gif);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });
  });
});
