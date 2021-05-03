import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IFavorite } from '../favorite.model';
import { FavoriteService } from '../service/favorite.service';
import { FavoriteDeleteDialogComponent } from '../delete/favorite-delete-dialog.component';

@Component({
  selector: 'jhi-favorite',
  templateUrl: './favorite.component.html',
})
export class FavoriteComponent implements OnInit {
  favorites?: IFavorite[];
  isLoading = false;

  constructor(protected favoriteService: FavoriteService, protected modalService: NgbModal) {}

  loadAll(): void {
    this.isLoading = true;

    this.favoriteService.query().subscribe(
      (res: HttpResponse<IFavorite[]>) => {
        this.isLoading = false;
        this.favorites = res.body ?? [];
      },
      () => {
        this.isLoading = false;
      }
    );
  }

  ngOnInit(): void {
    this.loadAll();
  }

  trackId(index: number, item: IFavorite): number {
    return item.id!;
  }

  delete(favorite: IFavorite): void {
    const modalRef = this.modalService.open(FavoriteDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.favorite = favorite;
    // unsubscribe not needed because closed completes on modal close
    modalRef.closed.subscribe(reason => {
      if (reason === 'deleted') {
        this.loadAll();
      }
    });
  }
}
