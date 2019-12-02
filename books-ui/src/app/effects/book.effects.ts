import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {BookAction, BookActionType, BookAdd, BookAdded, BookAddFailed, BookLoaded} from '../actions/book-action';
import {catchError, map, switchMap} from 'rxjs/operators';
import {BookApiService} from '../services/book-api.service';

@Injectable()
export class BookEffects {
  constructor(private actions$: Actions, private bookApiService: BookApiService) {
  }

  @Effect()
  add$: Observable<BookAction> = this.actions$.pipe(
    ofType(BookActionType.Add),
    switchMap((action: BookAdd) => {
      return this.bookApiService.add(action.payload).pipe(
        map(response => response),
        switchMap(book => of(new BookAdded(book))),
      );
    }));

  @Effect()
  load$: Observable<BookAction> = this.actions$.pipe(
    ofType(BookActionType.Load),
    switchMap(() => {
      return this.bookApiService.get().pipe(map(response => {
        return new BookLoaded(response);
      }));
    }));
}
