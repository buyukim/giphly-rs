import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IGif } from 'app/shared/model/gif.model';
import { GifService } from './gif.service';

@Component({
  templateUrl: './gif-delete-dialog.component.html'
})
export class GifDeleteDialogComponent {
  gif?: IGif;

  constructor(protected gifService: GifService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.gifService.delete(id).subscribe(() => {
      this.eventManager.broadcast('gifListModification');
      this.activeModal.close();
    });
  }
}
