import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { IFavorite, Favorite } from '../favorite.model';
import { FavoriteService } from '../service/favorite.service';
import { IGif } from 'app/entities/gif/gif.model';
import { GifService } from 'app/entities/gif/service/gif.service';
import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';

@Component({
  selector: 'jhi-favorite-update',
  templateUrl: './favorite-update.component.html',
})
export class FavoriteUpdateComponent implements OnInit {
  isSaving = false;

  gifsSharedCollection: IGif[] = [];
  usersSharedCollection: IUser[] = [];

  editForm = this.fb.group({
    id: [],
    gif: [],
    user: [],
  });

  constructor(
    protected favoriteService: FavoriteService,
    protected gifService: GifService,
    protected userService: UserService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ favorite }) => {
      this.updateForm(favorite);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const favorite = this.createFromForm();
    if (favorite.id !== undefined) {
      this.subscribeToSaveResponse(this.favoriteService.update(favorite));
    } else {
      this.subscribeToSaveResponse(this.favoriteService.create(favorite));
    }
  }

  trackGifById(index: number, item: IGif): number {
    return item.id!;
  }

  trackUserById(index: number, item: IUser): number {
    return item.id!;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFavorite>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(favorite: IFavorite): void {
    this.editForm.patchValue({
      id: favorite.id,
      gif: favorite.gif,
      user: favorite.user,
    });

    this.gifsSharedCollection = this.gifService.addGifToCollectionIfMissing(this.gifsSharedCollection, favorite.gif);
    this.usersSharedCollection = this.userService.addUserToCollectionIfMissing(this.usersSharedCollection, favorite.user);
  }

  protected loadRelationshipsOptions(): void {
    this.gifService
      .query()
      .pipe(map((res: HttpResponse<IGif[]>) => res.body ?? []))
      .pipe(map((gifs: IGif[]) => this.gifService.addGifToCollectionIfMissing(gifs, this.editForm.get('gif')!.value)))
      .subscribe((gifs: IGif[]) => (this.gifsSharedCollection = gifs));

    this.userService
      .query()
      .pipe(map((res: HttpResponse<IUser[]>) => res.body ?? []))
      .pipe(map((users: IUser[]) => this.userService.addUserToCollectionIfMissing(users, this.editForm.get('user')!.value)))
      .subscribe((users: IUser[]) => (this.usersSharedCollection = users));
  }

  protected createFromForm(): IFavorite {
    return {
      ...new Favorite(),
      id: this.editForm.get(['id'])!.value,
      gif: this.editForm.get(['gif'])!.value,
      user: this.editForm.get(['user'])!.value,
    };
  }
}
