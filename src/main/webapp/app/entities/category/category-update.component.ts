import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICategory, Category } from 'app/shared/model/category.model';
import { CategoryService } from './category.service';
import { IGif } from 'app/shared/model/gif.model';
import { GifService } from 'app/entities/gif/gif.service';

@Component({
  selector: 'jhi-category-update',
  templateUrl: './category-update.component.html'
})
export class CategoryUpdateComponent implements OnInit {
  isSaving = false;
  gifs: IGif[] = [];

  editForm = this.fb.group({
    id: [],
    tag: [null, [Validators.required]],
    gifs: []
  });

  constructor(
    protected categoryService: CategoryService,
    protected gifService: GifService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ category }) => {
      this.updateForm(category);

      this.gifService.query().subscribe((res: HttpResponse<IGif[]>) => (this.gifs = res.body || []));
    });
  }

  updateForm(category: ICategory): void {
    this.editForm.patchValue({
      id: category.id,
      tag: category.tag,
      gifs: category.gifs
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

  private createFromForm(): ICategory {
    return {
      ...new Category(),
      id: this.editForm.get(['id'])!.value,
      tag: this.editForm.get(['tag'])!.value,
      gifs: this.editForm.get(['gifs'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICategory>>): void {
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

  trackById(index: number, item: IGif): any {
    return item.id;
  }

  getSelected(selectedVals: IGif[], option: IGif): IGif {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
