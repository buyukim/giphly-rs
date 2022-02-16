import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IGif } from 'app/shared/model/gif.model';
import { GifService } from './gif.service';
import { GifDeleteDialogComponent } from './gif-delete-dialog.component';

@Component({
  selector: 'jhi-gif',
  templateUrl: './gif.component.html',
})
export class GifComponent implements OnInit, OnDestroy {
  gifs?: IGif[];
  eventSubscriber?: Subscription;

  constructor(protected gifService: GifService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.gifService.query().subscribe((res: HttpResponse<IGif[]>) => (this.gifs = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInGifs();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IGif): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInGifs(): void {
    this.eventSubscriber = this.eventManager.subscribe('gifListModification', () => this.loadAll());
  }

  delete(gif: IGif): void {
    const modalRef = this.modalService.open(GifDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.gif = gif;
  }
}
