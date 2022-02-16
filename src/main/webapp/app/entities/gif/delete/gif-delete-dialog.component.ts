import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { IGif } from '../gif.model';
import { GifService } from '../service/gif.service';

@Component({
  templateUrl: './gif-delete-dialog.component.html',
})
export class GifDeleteDialogComponent {
  gif?: IGif;

  constructor(protected gifService: GifService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.gifService.delete(id).subscribe(() => {
      this.activeModal.close('deleted');
    });
  }
}
