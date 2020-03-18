import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IGif } from 'app/shared/model/gif.model';

type EntityResponseType = HttpResponse<IGif>;
type EntityArrayResponseType = HttpResponse<IGif[]>;

@Injectable({ providedIn: 'root' })
export class GifService {
  public resourceUrl = SERVER_API_URL + 'api/gifs';

  constructor(protected http: HttpClient) {}

  create(gif: IGif): Observable<EntityResponseType> {
    return this.http.post<IGif>(this.resourceUrl, gif, { observe: 'response' });
  }

  update(gif: IGif): Observable<EntityResponseType> {
    return this.http.put<IGif>(this.resourceUrl, gif, { observe: 'response' });
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
}
