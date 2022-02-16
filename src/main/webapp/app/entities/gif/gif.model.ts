import { ICategory } from 'app/entities/category/category.model';

export interface IGif {
  id?: number;
  giphyGifId?: string;
  categories?: ICategory[] | null;
}

export class Gif implements IGif {
  constructor(public id?: number, public giphyGifId?: string, public categories?: ICategory[] | null) {}
}

export function getGifIdentifier(gif: IGif): number | undefined {
  return gif.id;
}
