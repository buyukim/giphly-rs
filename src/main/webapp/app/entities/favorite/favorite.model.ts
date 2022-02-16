import { IGif } from 'app/entities/gif/gif.model';
import { IUser } from 'app/entities/user/user.model';

export interface IFavorite {
  id?: number;
  gif?: IGif | null;
  user?: IUser | null;
}

export class Favorite implements IFavorite {
  constructor(public id?: number, public gif?: IGif | null, public user?: IUser | null) {}
}

export function getFavoriteIdentifier(favorite: IFavorite): number | undefined {
  return favorite.id;
}
