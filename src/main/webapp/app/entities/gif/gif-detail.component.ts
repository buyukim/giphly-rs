import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IGif } from 'app/shared/model/gif.model';

@Component({
  selector: 'jhi-gif-detail',
  templateUrl: './gif-detail.component.html',
})
export class GifDetailComponent implements OnInit {
  gif: IGif | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ gif }) => (this.gif = gif));
  }

  previousState(): void {
    window.history.back();
  }
}
