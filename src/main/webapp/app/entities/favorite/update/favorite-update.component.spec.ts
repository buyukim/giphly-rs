jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { FavoriteService } from '../service/favorite.service';
import { IFavorite, Favorite } from '../favorite.model';
import { IGif } from 'app/entities/gif/gif.model';
import { GifService } from 'app/entities/gif/service/gif.service';

import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';

import { FavoriteUpdateComponent } from './favorite-update.component';

describe('Component Tests', () => {
  describe('Favorite Management Update Component', () => {
    let comp: FavoriteUpdateComponent;
    let fixture: ComponentFixture<FavoriteUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let favoriteService: FavoriteService;
    let gifService: GifService;
    let userService: UserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [FavoriteUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(FavoriteUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FavoriteUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      favoriteService = TestBed.inject(FavoriteService);
      gifService = TestBed.inject(GifService);
      userService = TestBed.inject(UserService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should call Gif query and add missing value', () => {
        const favorite: IFavorite = { id: 456 };
        const gif: IGif = { id: 42058 };
        favorite.gif = gif;

        const gifCollection: IGif[] = [{ id: 74171 }];
        spyOn(gifService, 'query').and.returnValue(of(new HttpResponse({ body: gifCollection })));
        const additionalGifs = [gif];
        const expectedCollection: IGif[] = [...additionalGifs, ...gifCollection];
        spyOn(gifService, 'addGifToCollectionIfMissing').and.returnValue(expectedCollection);

        activatedRoute.data = of({ favorite });
        comp.ngOnInit();

        expect(gifService.query).toHaveBeenCalled();
        expect(gifService.addGifToCollectionIfMissing).toHaveBeenCalledWith(gifCollection, ...additionalGifs);
        expect(comp.gifsSharedCollection).toEqual(expectedCollection);
      });

      it('Should call User query and add missing value', () => {
        const favorite: IFavorite = { id: 456 };
        const user: IUser = { id: 15385 };
        favorite.user = user;

        const userCollection: IUser[] = [{ id: 70324 }];
        spyOn(userService, 'query').and.returnValue(of(new HttpResponse({ body: userCollection })));
        const additionalUsers = [user];
        const expectedCollection: IUser[] = [...additionalUsers, ...userCollection];
        spyOn(userService, 'addUserToCollectionIfMissing').and.returnValue(expectedCollection);

        activatedRoute.data = of({ favorite });
        comp.ngOnInit();

        expect(userService.query).toHaveBeenCalled();
        expect(userService.addUserToCollectionIfMissing).toHaveBeenCalledWith(userCollection, ...additionalUsers);
        expect(comp.usersSharedCollection).toEqual(expectedCollection);
      });

      it('Should update editForm', () => {
        const favorite: IFavorite = { id: 456 };
        const gif: IGif = { id: 90089 };
        favorite.gif = gif;
        const user: IUser = { id: 96316 };
        favorite.user = user;

        activatedRoute.data = of({ favorite });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(favorite));
        expect(comp.gifsSharedCollection).toContain(gif);
        expect(comp.usersSharedCollection).toContain(user);
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject();
        const favorite = { id: 123 };
        spyOn(favoriteService, 'update').and.returnValue(saveSubject);
        spyOn(comp, 'previousState');
        activatedRoute.data = of({ favorite });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: favorite }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(favoriteService.update).toHaveBeenCalledWith(favorite);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject();
        const favorite = new Favorite();
        spyOn(favoriteService, 'create').and.returnValue(saveSubject);
        spyOn(comp, 'previousState');
        activatedRoute.data = of({ favorite });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: favorite }));
        saveSubject.complete();

        // THEN
        expect(favoriteService.create).toHaveBeenCalledWith(favorite);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject();
        const favorite = { id: 123 };
        spyOn(favoriteService, 'update').and.returnValue(saveSubject);
        spyOn(comp, 'previousState');
        activatedRoute.data = of({ favorite });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(favoriteService.update).toHaveBeenCalledWith(favorite);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });

    describe('Tracking relationships identifiers', () => {
      describe('trackGifById', () => {
        it('Should return tracked Gif primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackGifById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });

      describe('trackUserById', () => {
        it('Should return tracked User primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackUserById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });
    });
  });
});
