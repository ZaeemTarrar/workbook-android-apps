# Andriod Application Development

## Manifest

### AndroidManifest.xml

**Folder:** `app/manifest/`

This File Involves the Following;

- Application Icon/Icons
- Application Label/Labels
- Application Themes
- Application Meta Data
- Application Permissions
- Application Activities


## Activities

**Folder:** `app/java/com.example.application/MainActivity`

Every Screen View is said to be an Activity in Android App Development

### Methods / Classed

- findViewById()
- R
	- R.id.{}
	- r.color.{}
- InputMethodManager ( to hide keypad after usage )
```java
InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
```


## Resources

**Folder:** `app/res/`

- Drawables
- Layout
- MipMap
- Values
	- Colors
	- Strings
	- Styles
	- Dimensions
	- Themes
		- Themes
		- Themes ( night )

## Views

### Layouts

- Linear Layout
- Constraint Layout
- Scroll View Layout

### Heirarchy

- View
	- TextView
		- Button
		- Edit Text
	- ImageView
	- ViewGroup
		- Linear Layout
		- Contraint Layout
		- Frame Layout
			- Scroll View
