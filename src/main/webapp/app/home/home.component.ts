import { Component, OnInit, OnDestroy, ViewChild, ElementRef } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/auth/account.model';

import { of } from 'rxjs';
import { debounceTime, map, distinctUntilChanged, filter } from 'rxjs/operators';
import { fromEvent } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit, OnDestroy {
  account: Account | null = null;

  @ViewChild('gifSearchInput', { static: true })
  gifSearchInput!: ElementRef;
  searchApiResponse: any;
  isSearching: boolean;

  private readonly destroy$ = new Subject<void>();

  constructor(private accountService: AccountService, private router: Router, private httpClient: HttpClient) {
    this.isSearching = false;
    this.searchApiResponse = [];
  }

  ngOnInit(): void {
    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe(account => (this.account = account));

    fromEvent(this.gifSearchInput.nativeElement, 'keyup')
      .pipe(
        // get value
        map(
          (event: any) =>
            // eslint-disable-next-line @typescript-eslint/no-unsafe-return
            event.target.value
        ),
        // if character length greater then 2
        filter(res => res.length > 2),
        // Time in milliseconds between key events
        debounceTime(1000),
        // If previous query is diffent from current
        distinctUntilChanged()
        // subscription for response
      )
      .subscribe((text: string) => {
        this.isSearching = true;
        this.searchGetCall(text).subscribe(
          res => {
            // console.log('res',res);
            this.isSearching = false;
            this.searchApiResponse = res;
          },
          () => {
            this.isSearching = false;
            // console.log('error',err);
          }
        );
      });
  }

  // eslint-disable-next-line @typescript-eslint/ban-types
  searchGetCall(term: string): Observable<Object> {
    if (term === '') {
      return of([]);
    }
    return this.httpClient.get('/api/giphy-gifs/search?limit=24&q=' + term);
  }

  login(): void {
    this.router.navigate(['/login']);
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
