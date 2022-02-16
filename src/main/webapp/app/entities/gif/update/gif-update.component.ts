import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { IGif, Gif } from '../gif.model';
import { GifService } from '../service/gif.service';

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

  constructor(protected gifService: GifService, protected activatedRoute: ActivatedRoute, protected fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ gif }) => {
      this.updateForm(gif);
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

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IGif>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
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

  protected updateForm(gif: IGif): void {
    this.editForm.patchValue({
      id: gif.id,
      giphyGifId: gif.giphyGifId,
    });
  }

  protected createFromForm(): IGif {
    return {
      ...new Gif(),
      id: this.editForm.get(['id'])!.value,
      giphyGifId: this.editForm.get(['giphyGifId'])!.value,
    };
  }
}
