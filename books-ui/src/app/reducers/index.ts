import {ActionReducerMap} from '@ngrx/store';
import {bookReducer} from './book-reducer';
import {Book} from '../entities/book';

export interface AppState {
  readonly books: Book[];
}

export const reducers: ActionReducerMap<any> = {
  books: bookReducer
};
