# angular-dashboard-full-stack

## [1.1.0] - 29-05-2018
### Update
- update angular 4 to 5 from site and add custom api integration components

#### My customization
- rename package.json, documentation and angular-cli.json with my app name
- user-profile
- table-list (change also routing in user-list)
- used in table-list.component.ts this.router.navigate(['/user-profile', id]); and in user-profile.component.ts  the let id = this.root.snapshot.paramMap.get('id'); to retrieve passing data. For this root: ActivatedRoute of import { Router, ActivatedRoute } from '@angular/router'; in constructor
- add { path: 'user-profile/:id', component: UserProfileComponent }, in layouts/admin-layout/admin-layout.routing.ts to allows passing id
- sweetalert2 dependency
- import { HttpClientModule } from '@angular/common/http';  and HttpComponent instead HttpModule from @http in app/app.module.ts
- providers: [UserService] in app/app.module.ts
- BrowserModule, HttpClientModule imports in app/app.module.ts
- page-not-found with { path: '**',  component: PageNotFoundComponent } in layouts/admin-layout/admin-layout.routing.ts 
- assets/img/my-logo.png for src/app/components/sidebar/sidebar.component.html and assets/img/faces/marc.jpg that is my photo 
- change Creative Tim with Creative Plus in all html


## [1.0.0] - 28-09-2017
### Added
- added angular 4 material dashboard from site
