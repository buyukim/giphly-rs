import { ICategory } from 'app/shared/model/category.model';

export interface IGif {
  id?: number;
  giphyGifId?: string;
  categories?: ICategory[];
}

export class Gif implements IGif {
  constructor(public id?: number, public giphyGifId?: string, public categories?: ICategory[]) {}
}
