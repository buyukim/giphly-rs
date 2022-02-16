import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IGif, Gif } from '../gif.model';
import { GifService } from '../service/gif.service';

@Injectable({ providedIn: 'root' })
export class GifRoutingResolveService implements Resolve<IGif> {
  constructor(protected service: GifService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IGif> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((gif: HttpResponse<Gif>) => {
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
