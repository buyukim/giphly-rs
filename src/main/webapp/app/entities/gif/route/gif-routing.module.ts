import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { GifComponent } from '../list/gif.component';
import { GifDetailComponent } from '../detail/gif-detail.component';
import { GifUpdateComponent } from '../update/gif-update.component';
import { GifRoutingResolveService } from './gif-routing-resolve.service';

const gifRoute: Routes = [
  {
    path: '',
    component: GifComponent,
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: GifDetailComponent,
    resolve: {
      gif: GifRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: GifUpdateComponent,
    resolve: {
      gif: GifRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: GifUpdateComponent,
    resolve: {
      gif: GifRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(gifRoute)],
  exports: [RouterModule],
})
export class GifRoutingModule {}
