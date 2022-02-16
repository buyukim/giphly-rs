import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { ICategory, Category } from '../category.model';
import { CategoryService } from '../service/category.service';
import { IGif } from 'app/entities/gif/gif.model';
import { GifService } from 'app/entities/gif/service/gif.service';

@Component({
  selector: 'jhi-category-update',
  templateUrl: './category-update.component.html',
})
export class CategoryUpdateComponent implements OnInit {
  isSaving = false;

  gifsSharedCollection: IGif[] = [];

  editForm = this.fb.group({
    id: [],
    tag: [null, [Validators.required]],
    gifs: [],
  });

  constructor(
    protected categoryService: CategoryService,
    protected gifService: GifService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ category }) => {
      this.updateForm(category);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const category = this.createFromForm();
    if (category.id !== undefined) {
      this.subscribeToSaveResponse(this.categoryService.update(category));
    } else {
      this.subscribeToSaveResponse(this.categoryService.create(category));
    }
  }

  trackGifById(index: number, item: IGif): number {
    return item.id!;
  }

  getSelectedGif(option: IGif, selectedVals?: IGif[]): IGif {
    if (selectedVals) {
      for (const selectedVal of selectedVals) {
        if (option.id === selectedVal.id) {
          return selectedVal;
        }
      }
    }
    return option;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICategory>>): void {
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

  protected updateForm(category: ICategory): void {
    this.editForm.patchValue({
      id: category.id,
      tag: category.tag,
      gifs: category.gifs,
    });

    this.gifsSharedCollection = this.gifService.addGifToCollectionIfMissing(this.gifsSharedCollection, ...(category.gifs ?? []));
  }

  protected loadRelationshipsOptions(): void {
    this.gifService
      .query()
      .pipe(map((res: HttpResponse<IGif[]>) => res.body ?? []))
      .pipe(map((gifs: IGif[]) => this.gifService.addGifToCollectionIfMissing(gifs, ...(this.editForm.get('gifs')!.value ?? []))))
      .subscribe((gifs: IGif[]) => (this.gifsSharedCollection = gifs));
  }

  protected createFromForm(): ICategory {
    return {
      ...new Category(),
      id: this.editForm.get(['id'])!.value,
      tag: this.editForm.get(['tag'])!.value,
      gifs: this.editForm.get(['gifs'])!.value,
    };
  }
}
