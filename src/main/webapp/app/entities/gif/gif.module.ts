import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';
import { GifComponent } from './list/gif.component';
import { GifDetailComponent } from './detail/gif-detail.component';
import { GifUpdateComponent } from './update/gif-update.component';
import { GifDeleteDialogComponent } from './delete/gif-delete-dialog.component';
import { GifRoutingModule } from './route/gif-routing.module';

@NgModule({
  imports: [SharedModule, GifRoutingModule],
  declarations: [GifComponent, GifDetailComponent, GifUpdateComponent, GifDeleteDialogComponent],
  entryComponents: [GifDeleteDialogComponent],
})
export class GifModule {}
