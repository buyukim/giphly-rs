import { IGif } from 'app/shared/model/gif.model';

export interface ICategory {
  id?: number;
  tag?: string;
  gifs?: IGif[];
}

export class Category implements ICategory {
  constructor(public id?: number, public tag?: string, public gifs?: IGif[]) {}
}
