import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

import { FavoriteService } from '../service/favorite.service';

import { FavoriteComponent } from './favorite.component';

describe('Favorite Management Component', () => {
  let comp: FavoriteComponent;
  let fixture: ComponentFixture<FavoriteComponent>;
  let service: FavoriteService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [FavoriteComponent],
    })
      .overrideTemplate(FavoriteComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(FavoriteComponent);
    comp = fixture.componentInstance;
    service = TestBed.inject(FavoriteService);

    const headers = new HttpHeaders();
    jest.spyOn(service, 'query').mockReturnValue(
      of(
        new HttpResponse({
          body: [{ id: 123 }],
          headers,
        })
      )
    );
  });

  it('Should call load all on init', () => {
    // WHEN
    comp.ngOnInit();

    // THEN
    expect(service.query).toHaveBeenCalled();
    expect(comp.favorites?.[0]).toEqual(expect.objectContaining({ id: 123 }));
  });
});
