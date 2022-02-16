import { IGif } from 'app/shared/model/gif.model';
import { IUser } from 'app/core/user/user.model';

export interface IFavorite {
  id?: number;
  gif?: IGif;
  user?: IUser;
}

export class Favorite implements IFavorite {
  constructor(public id?: number, public gif?: IGif, public user?: IUser) {}
}
