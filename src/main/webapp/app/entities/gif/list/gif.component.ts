import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IGif } from '../gif.model';
import { GifService } from '../service/gif.service';
import { GifDeleteDialogComponent } from '../delete/gif-delete-dialog.component';

@Component({
  selector: 'jhi-gif',
  templateUrl: './gif.component.html',
})
export class GifComponent implements OnInit {
  gifs?: IGif[];
  isLoading = false;

  constructor(protected gifService: GifService, protected modalService: NgbModal) {}

  loadAll(): void {
    this.isLoading = true;

    this.gifService.query().subscribe(
      (res: HttpResponse<IGif[]>) => {
        this.isLoading = false;
        this.gifs = res.body ?? [];
      },
      () => {
        this.isLoading = false;
      }
    );
  }

  ngOnInit(): void {
    this.loadAll();
  }

  trackId(index: number, item: IGif): number {
    return item.id!;
  }

  delete(gif: IGif): void {
    const modalRef = this.modalService.open(GifDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.gif = gif;
    // unsubscribe not needed because closed completes on modal close
    modalRef.closed.subscribe(reason => {
      if (reason === 'deleted') {
        this.loadAll();
      }
    });
  }
}
