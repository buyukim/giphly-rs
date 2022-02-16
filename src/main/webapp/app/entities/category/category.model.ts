import { IGif } from 'app/entities/gif/gif.model';

export interface ICategory {
  id?: number;
  tag?: string;
  gifs?: IGif[] | null;
}

export class Category implements ICategory {
  constructor(public id?: number, public tag?: string, public gifs?: IGif[] | null) {}
}

export function getCategoryIdentifier(category: ICategory): number | undefined {
  return category.id;
}
