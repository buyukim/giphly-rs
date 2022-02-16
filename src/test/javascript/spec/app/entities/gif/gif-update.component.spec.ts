import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { GiphlyTestModule } from '../../../test.module';
import { GifUpdateComponent } from 'app/entities/gif/gif-update.component';
import { GifService } from 'app/entities/gif/gif.service';
import { Gif } from 'app/shared/model/gif.model';

describe('Component Tests', () => {
  describe('Gif Management Update Component', () => {
    let comp: GifUpdateComponent;
    let fixture: ComponentFixture<GifUpdateComponent>;
    let service: GifService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GiphlyTestModule],
        declarations: [GifUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(GifUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(GifUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(GifService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Gif(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new Gif();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
