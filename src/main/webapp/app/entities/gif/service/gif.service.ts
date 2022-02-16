import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IGif, getGifIdentifier } from '../gif.model';

export type EntityResponseType = HttpResponse<IGif>;
export type EntityArrayResponseType = HttpResponse<IGif[]>;

@Injectable({ providedIn: 'root' })
export class GifService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/gifs');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(gif: IGif): Observable<EntityResponseType> {
    return this.http.post<IGif>(this.resourceUrl, gif, { observe: 'response' });
  }

  update(gif: IGif): Observable<EntityResponseType> {
    return this.http.put<IGif>(`${this.resourceUrl}/${getGifIdentifier(gif) as number}`, gif, { observe: 'response' });
  }

  partialUpdate(gif: IGif): Observable<EntityResponseType> {
    return this.http.patch<IGif>(`${this.resourceUrl}/${getGifIdentifier(gif) as number}`, gif, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IGif>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IGif[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addGifToCollectionIfMissing(gifCollection: IGif[], ...gifsToCheck: (IGif | null | undefined)[]): IGif[] {
    const gifs: IGif[] = gifsToCheck.filter(isPresent);
    if (gifs.length > 0) {
      const gifCollectionIdentifiers = gifCollection.map(gifItem => getGifIdentifier(gifItem)!);
      const gifsToAdd = gifs.filter(gifItem => {
        const gifIdentifier = getGifIdentifier(gifItem);
        if (gifIdentifier == null || gifCollectionIdentifiers.includes(gifIdentifier)) {
          return false;
        }
        gifCollectionIdentifiers.push(gifIdentifier);
        return true;
      });
      return [...gifsToAdd, ...gifCollection];
    }
    return gifCollection;
  }
}
