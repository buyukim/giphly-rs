import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'gif',
        data: { pageTitle: 'giphlyApp.gif.home.title' },
        loadChildren: () => import('./gif/gif.module').then(m => m.GifModule),
      },
      {
        path: 'category',
        data: { pageTitle: 'giphlyApp.category.home.title' },
        loadChildren: () => import('./category/category.module').then(m => m.CategoryModule),
      },
      {
        path: 'favorite',
        data: { pageTitle: 'giphlyApp.favorite.home.title' },
        loadChildren: () => import('./favorite/favorite.module').then(m => m.FavoriteModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
