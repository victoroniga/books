import {BookAction, BookActionType} from '../actions/book-action';
import {Book} from '../entities/book';
import {AppState} from './index';

export function bookReducer(state: Book[] = [], action: BookAction): any | AppState {
  switch (action.type) {
    case BookActionType.Added:
      return [...state, action.payload];
    case BookActionType.Loaded:
      state = action.payload;
      return state;
    default:
      return state;
  }
}
