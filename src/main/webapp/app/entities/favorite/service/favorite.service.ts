import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IFavorite, getFavoriteIdentifier } from '../favorite.model';

export type EntityResponseType = HttpResponse<IFavorite>;
export type EntityArrayResponseType = HttpResponse<IFavorite[]>;

@Injectable({ providedIn: 'root' })
export class FavoriteService {
  public resourceUrl = this.applicationConfigService.getEndpointFor('api/favorites');

  constructor(protected http: HttpClient, private applicationConfigService: ApplicationConfigService) {}

  create(favorite: IFavorite): Observable<EntityResponseType> {
    return this.http.post<IFavorite>(this.resourceUrl, favorite, { observe: 'response' });
  }

  update(favorite: IFavorite): Observable<EntityResponseType> {
    return this.http.put<IFavorite>(`${this.resourceUrl}/${getFavoriteIdentifier(favorite) as number}`, favorite, { observe: 'response' });
  }

  partialUpdate(favorite: IFavorite): Observable<EntityResponseType> {
    return this.http.patch<IFavorite>(`${this.resourceUrl}/${getFavoriteIdentifier(favorite) as number}`, favorite, {
      observe: 'response',
    });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IFavorite>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IFavorite[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addFavoriteToCollectionIfMissing(favoriteCollection: IFavorite[], ...favoritesToCheck: (IFavorite | null | undefined)[]): IFavorite[] {
    const favorites: IFavorite[] = favoritesToCheck.filter(isPresent);
    if (favorites.length > 0) {
      const favoriteCollectionIdentifiers = favoriteCollection.map(favoriteItem => getFavoriteIdentifier(favoriteItem)!);
      const favoritesToAdd = favorites.filter(favoriteItem => {
        const favoriteIdentifier = getFavoriteIdentifier(favoriteItem);
        if (favoriteIdentifier == null || favoriteCollectionIdentifiers.includes(favoriteIdentifier)) {
          return false;
        }
        favoriteCollectionIdentifiers.push(favoriteIdentifier);
        return true;
      });
      return [...favoritesToAdd, ...favoriteCollection];
    }
    return favoriteCollection;
  }
}
