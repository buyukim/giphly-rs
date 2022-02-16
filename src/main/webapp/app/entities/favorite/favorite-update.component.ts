import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IFavorite, Favorite } from 'app/shared/model/favorite.model';
import { FavoriteService } from './favorite.service';
import { IGif } from 'app/shared/model/gif.model';
import { GifService } from 'app/entities/gif/gif.service';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';

type SelectableEntity = IGif | IUser;

@Component({
  selector: 'jhi-favorite-update',
  templateUrl: './favorite-update.component.html',
})
export class FavoriteUpdateComponent implements OnInit {
  isSaving = false;
  gifs: IGif[] = [];
  users: IUser[] = [];

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
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ favorite }) => {
      this.updateForm(favorite);

      this.gifService.query().subscribe((res: HttpResponse<IGif[]>) => (this.gifs = res.body || []));

      this.userService.query().subscribe((res: HttpResponse<IUser[]>) => (this.users = res.body || []));
    });
  }

  updateForm(favorite: IFavorite): void {
    this.editForm.patchValue({
      id: favorite.id,
      gif: favorite.gif,
      user: favorite.user,
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

  private createFromForm(): IFavorite {
    return {
      ...new Favorite(),
      id: this.editForm.get(['id'])!.value,
      gif: this.editForm.get(['gif'])!.value,
      user: this.editForm.get(['user'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFavorite>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
