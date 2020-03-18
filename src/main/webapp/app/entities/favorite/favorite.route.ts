import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IFavorite, Favorite } from 'app/shared/model/favorite.model';
import { FavoriteService } from './favorite.service';
import { FavoriteComponent } from './favorite.component';
import { FavoriteDetailComponent } from './favorite-detail.component';
import { FavoriteUpdateComponent } from './favorite-update.component';

@Injectable({ providedIn: 'root' })
export class FavoriteResolve implements Resolve<IFavorite> {
  constructor(private service: FavoriteService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IFavorite> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((favorite: HttpResponse<Favorite>) => {
          if (favorite.body) {
            return of(favorite.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Favorite());
  }
}

export const favoriteRoute: Routes = [
  {
    path: '',
    component: FavoriteComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'giphlyApp.favorite.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: FavoriteDetailComponent,
    resolve: {
      favorite: FavoriteResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'giphlyApp.favorite.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: FavoriteUpdateComponent,
    resolve: {
      favorite: FavoriteResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'giphlyApp.favorite.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: FavoriteUpdateComponent,
    resolve: {
      favorite: FavoriteResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'giphlyApp.favorite.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
