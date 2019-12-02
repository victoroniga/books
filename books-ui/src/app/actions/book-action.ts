import {Action} from '@ngrx/store';
import {Book} from '../entities/book';

export enum BookActionType {
  Add = '[Book] Add book',
  Load = '[Book] Load books',
  Added = '[Book] Book added',
  Loaded = '[Book] Books loaded',
  AddFailed = '[Book] Book add failed'
}

export class BookAction implements Action {
  readonly type;
  payload: any;
}

export class BookAdd implements BookAction {
  readonly type = BookActionType.Add;

  constructor(public payload: Book) {
  }
}

export class BookLoad implements BookAction {
  readonly type = BookActionType.Load;

  constructor(public payload: any) {
  }
}

export class BookAdded implements BookAction {
  readonly type = BookActionType.Added;

  constructor(public payload: Book) {
  }
}

export class BookLoaded implements BookAction {
  readonly type = BookActionType.Loaded;

  constructor(public payload: Book[]) {
  }
}

export class BookAddFailed implements BookAction {
  readonly type = BookActionType.AddFailed;

  constructor(public payload: Error) {
  }
}
