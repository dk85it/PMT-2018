/*Minify
CSS and JavaScript minifier

CDE ON GITHUB
MINIFY A JAVASCRIPT OR CSS FILE


(function($){$.pwstrength=function(password){var score=0,length=password.length,upperCase,lowerCase,digits,nonAlpha;if(length<5)score+=0;else if(length<8)score+=5;else if(length<16)score+=10;else score+=15;lowerCase=password.match(/[a-z]/g);if(lowerCase)score+=1;upperCase=password.match(/[A-Z]/g);if(upperCase)score+=5;if(upperCase&&lowerCase)score+=2;digits=password.match(/\d/g);if(digits&&digits.length>1)score+=5;nonAlpha=password.match(/\W/g)
if(nonAlpha)score+=(nonAlpha.length>1)?15:10;if(upperCase&&lowerCase&&digits&&nonAlpha)score+=15;if(password.match(/\s/))score+=10;if(score<15)return 0;if(score<20)return 1;if(score<35)return 2;if(score<50)return 3;return 4};function updateIndicator(event){var strength=$.pwstrength($(this).val()),options=event.data,klass;klass=options.classes[strength];options.indicator.removeClass(options.indicator.data('pwclass'));options.indicator.data('pwclass',klass);options.indicator.addClass(klass);options.indicator.find(options.label).html(options.texts[strength])}
$.fn.pwstrength=function(options){var options=$.extend({label:'.label',classes:['pw-very-weak','pw-weak','pw-mediocre','pw-strong','pw-very-strong'],texts:['very weak','weak','mediocre','strong','very strong']},options||{});options.indicator=$('#'+this.data('indicator'));return this.keyup(options,updateIndicator)}})(jQuery)
Original script: 2282b, minified script: 1337b. Gain: 945b.  JS
 CSS MINIFY
USE

Simply add a dependency on matthiasmullie/minify to your composer.json file if you use Composer to manage the dependencies of your project:

composer require matthiasmullie/minify
Although it's recommended to use Composer, you can actually include these files anyway you want.

CONTRIBUTE

Dig into to the code. It's MIT-licensed, so you're allowed to do pretty much anything with it.

git clone git@github.com:matthiasmullie/minify.git
Fork the repository on GitHub, and send your pull requests! Any kind of help is welcome.

BUGS?

Please submit any issue you encounter.

In order to easily grasp the issue, be as thorough as possible in describing the bug! Please include the original JavaScript or CSS code, the incorrect minified result & the expected result

Bonus points for including a pull request with the issue added to the test suite!

DOCS

 Build status Code coverage Code quality Latest version Downloads total License

Available methods, for both CSS & JS minifier, are:

__construct( overload paths )

The object constructor accepts 0, 1 or multiple paths of files, or even complete CSS/JS content, that should be minified. All CSS/JS passed along, will be combined into 1 minified file.

use MatthiasMullie\Minify;
$minifier = new Minify\JS($path1, $path2);
add($path,  overload paths )

This is roughly equivalent to the constructor.

$minifier->add($path3);
$minifier->add($js);
minify($path)

This will minify the files' content, save the result to $path and return the resulting content. If the $path parameter is omitted, the result will not be written anywhere.

CAUTION: If you have CSS with relative paths (to imports, images, ...), you should always specify a target path! Then those relative paths will be adjusted in accordance with the new path.

$minifier->minify('/target/path.js');
gzip($path, $level)

Minifies and optionally saves to a file, just like minify(), but it also gzencode()s the minified content.

$minifier->gzip('/target/path.js');
setMaxImportSize($size) (CSS only)

The CSS minifier will automatically embed referenced files (like images, fonts, ...) into the minified CSS, so they don't have to be fetched over multiple connections.

However, for really large files, it's likely better to load them separately (as it would increase the CSS load time if they were included.)

This method allows the max size of files to import into the minified CSS to be set (in kB). The default size is 5.

$minifier->setMaxImportSize(10);
setImportExtensions($extensions) (CSS only)

The CSS minifier will automatically embed referenced files (like images, fonts, ...) into minified CSS, so they don't have to be fetched over multiple connections.

This methods allows the type of files to be specified, along with their data:mime type.

The default embedded file types are gif, png, jpg, jpeg, svg & woff.

$extensions = array(
    'gif' => 'data:image/gif',
    'png' => 'data:image/png',
);

$minifier->setImportExtensions($extensions);
EXAMPLE USAGE

JAVASCRIPT

use MatthiasMullie\Minify;

$sourcePath = '/path/to/source/css/file.js';
$minifier = new Minify\JS($sourcePath);

// we can even add another file, they'll then be
// joined in 1 output file
$sourcePath2 = '/path/to/second/source/css/file.js';
$minifier->add($sourcePath2);

// or we can just add plain js
$js = 'var test = 1';
$minifier->add($js);

// save minified file to disk
$minifiedPath = '/path/to/minified/js/file.js';
$minifier->minify($minifiedPath);

// or just output the content
echo $minifier->minify();
CSS

use MatthiasMullie\Minify;

$sourcePath = '/path/to/source/css/file.css';
$minifier = new Minify\CSS($sourcePath);

// we can even add another file, they'll then be
// joined in 1 output file
$sourcePath2 = '/path/to/second/source/css/file.css';
$minifier->add($sourcePath2);

// or we can just add plain CSS
$css = 'body { color: #000000; }';
$minifier->add($css);

// save minified file to disk
$minifiedPath = '/path/to/minified/css/file.css';
$minifier->minify($minifiedPath);

// or just output the content
echo $minifier->minify();
CHALLENGES

If you're interested in learning some of the harder technical challenges I've encountered building this, you probably want to take a look at what I wrote about it on my blog.

By Matthias Mullie:     

Design: Halcyon Days by Peter Finlan


*/