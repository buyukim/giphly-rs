import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IGif, Gif } from '../gif.model';

import { GifService } from './gif.service';

describe('Service Tests', () => {
  describe('Gif Service', () => {
    let service: GifService;
    let httpMock: HttpTestingController;
    let elemDefault: IGif;
    let expectedResult: IGif | IGif[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      service = TestBed.inject(GifService);
      httpMock = TestBed.inject(HttpTestingController);

      elemDefault = {
        id: 0,
        giphyGifId: 'AAAAAAA',
      };
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a Gif', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Gif()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Gif', () => {
        const returnedFromService = Object.assign(
          {
            id: 1,
            giphyGifId: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should partial update a Gif', () => {
        const patchObject = Object.assign(
          {
            giphyGifId: 'BBBBBB',
          },
          new Gif()
        );

        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign({}, returnedFromService);

        service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PATCH' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Gif', () => {
        const returnedFromService = Object.assign(
          {
            id: 1,
            giphyGifId: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a Gif', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });

      describe('addGifToCollectionIfMissing', () => {
        it('should add a Gif to an empty array', () => {
          const gif: IGif = { id: 123 };
          expectedResult = service.addGifToCollectionIfMissing([], gif);
          expect(expectedResult).toHaveLength(1);
          expect(expectedResult).toContain(gif);
        });

        it('should not add a Gif to an array that contains it', () => {
          const gif: IGif = { id: 123 };
          const gifCollection: IGif[] = [
            {
              ...gif,
            },
            { id: 456 },
          ];
          expectedResult = service.addGifToCollectionIfMissing(gifCollection, gif);
          expect(expectedResult).toHaveLength(2);
        });

        it("should add a Gif to an array that doesn't contain it", () => {
          const gif: IGif = { id: 123 };
          const gifCollection: IGif[] = [{ id: 456 }];
          expectedResult = service.addGifToCollectionIfMissing(gifCollection, gif);
          expect(expectedResult).toHaveLength(2);
          expect(expectedResult).toContain(gif);
        });

        it('should add only unique Gif to an array', () => {
          const gifArray: IGif[] = [{ id: 123 }, { id: 456 }, { id: 31802 }];
          const gifCollection: IGif[] = [{ id: 123 }];
          expectedResult = service.addGifToCollectionIfMissing(gifCollection, ...gifArray);
          expect(expectedResult).toHaveLength(3);
        });

        it('should accept varargs', () => {
          const gif: IGif = { id: 123 };
          const gif2: IGif = { id: 456 };
          expectedResult = service.addGifToCollectionIfMissing([], gif, gif2);
          expect(expectedResult).toHaveLength(2);
          expect(expectedResult).toContain(gif);
          expect(expectedResult).toContain(gif2);
        });

        it('should accept null and undefined values', () => {
          const gif: IGif = { id: 123 };
          expectedResult = service.addGifToCollectionIfMissing([], null, gif, undefined);
          expect(expectedResult).toHaveLength(1);
          expect(expectedResult).toContain(gif);
        });
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
