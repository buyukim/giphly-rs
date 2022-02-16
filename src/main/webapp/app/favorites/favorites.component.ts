import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.scss'],
})
export class FavoritesComponent implements OnInit {
  // constructor() {}

  loadAll(): void {
    // this.categoryService.query().subscribe((res: HttpResponse<ICategory[]>) => (this.categories = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    // this.registerChangeInCategories();
  }
}
