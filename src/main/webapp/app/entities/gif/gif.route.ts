import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IGif, Gif } from 'app/shared/model/gif.model';
import { GifService } from './gif.service';
import { GifComponent } from './gif.component';
import { GifDetailComponent } from './gif-detail.component';
import { GifUpdateComponent } from './gif-update.component';

@Injectable({ providedIn: 'root' })
export class GifResolve implements Resolve<IGif> {
  constructor(private service: GifService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IGif> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((gif: HttpResponse<Gif>) => {
          if (gif.body) {
            return of(gif.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Gif());
  }
}

export const gifRoute: Routes = [
  {
    path: '',
    component: GifComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'giphlyApp.gif.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: GifDetailComponent,
    resolve: {
      gif: GifResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'giphlyApp.gif.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: GifUpdateComponent,
    resolve: {
      gif: GifResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'giphlyApp.gif.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: GifUpdateComponent,
    resolve: {
      gif: GifResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'giphlyApp.gif.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
