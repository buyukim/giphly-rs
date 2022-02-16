import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IGif, Gif } from 'app/shared/model/gif.model';
import { GifService } from './gif.service';

@Component({
  selector: 'jhi-gif-update',
  templateUrl: './gif-update.component.html',
})
export class GifUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    giphyGifId: [null, [Validators.required]],
  });

  constructor(protected gifService: GifService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ gif }) => {
      this.updateForm(gif);
    });
  }

  updateForm(gif: IGif): void {
    this.editForm.patchValue({
      id: gif.id,
      giphyGifId: gif.giphyGifId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const gif = this.createFromForm();
    if (gif.id !== undefined) {
      this.subscribeToSaveResponse(this.gifService.update(gif));
    } else {
      this.subscribeToSaveResponse(this.gifService.create(gif));
    }
  }

  private createFromForm(): IGif {
    return {
      ...new Gif(),
      id: this.editForm.get(['id'])!.value,
      giphyGifId: this.editForm.get(['giphyGifId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IGif>>): void {
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
}
