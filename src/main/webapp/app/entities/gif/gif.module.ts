import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GiphlySharedModule } from 'app/shared/shared.module';
import { GifComponent } from './gif.component';
import { GifDetailComponent } from './gif-detail.component';
import { GifUpdateComponent } from './gif-update.component';
import { GifDeleteDialogComponent } from './gif-delete-dialog.component';
import { gifRoute } from './gif.route';

@NgModule({
  imports: [GiphlySharedModule, RouterModule.forChild(gifRoute)],
  declarations: [GifComponent, GifDetailComponent, GifUpdateComponent, GifDeleteDialogComponent],
  entryComponents: [GifDeleteDialogComponent],
})
export class GiphlyGifModule {}
