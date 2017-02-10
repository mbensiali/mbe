import {Injectable} from '@angular/core'
import {Site} from '../metier/site';
import {BehaviorSubject, Observable} from 'rxjs/Rx';
import {Http} from '@angular/http';


@Injectable()
export class SiteService {

    private _sites : Site[];
    private _siteObservableBuilder : BehaviorSubject<Site[]>;
    private _searchterm: string;

    constructor(private _http : Http) {
        this._sites = [];
        this._searchterm = "";
        this._siteObservableBuilder = 
            new BehaviorSubject<Site[]>(this._sites);
        
    }

    ngOnInit(){
        
    }

    setSearch(searchterm: string) {
        this._searchterm = searchterm;
        if (this._searchterm === "") {
            this._siteObservableBuilder.next(this._sites);
        }
        else {
            this._siteObservableBuilder.next(
                this._sites.filter(
                    s => s.nom.indexOf(searchterm) != -1
                )
            );
        }

    }

    getSites() : Observable<Site[]> {
        return this._siteObservableBuilder.asObservable();
    }

    findByid(id: number) : Site {
        return this._sites.find(s => s.id == id);
    }
}