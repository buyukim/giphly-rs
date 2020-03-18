import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'gif',
        loadChildren: () => import('./gif/gif.module').then(m => m.GiphlyGifModule)
      },
      {
        path: 'category',
        loadChildren: () => import('./category/category.module').then(m => m.GiphlyCategoryModule)
      },
      {
        path: 'favorite',
        loadChildren: () => import('./favorite/favorite.module').then(m => m.GiphlyFavoriteModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class GiphlyEntityModule {}
