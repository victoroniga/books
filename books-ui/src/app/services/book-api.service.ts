import {Injectable} from '@angular/core';
import {Book} from '../entities/book';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BookApiService {

  // private baseUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  get(): Observable<Book[]> {
    return this.http.get<Book[]>(environment.baseUrl + '/book', httpOptions);
  }

  add(book: Book): Observable<Book> {
    return this.http.post<Book>(environment.baseUrl + '/book', book, httpOptions);
  }
}
