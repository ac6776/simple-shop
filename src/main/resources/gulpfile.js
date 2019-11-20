var gulp         = require('gulp'),
		sass         = require('gulp-sass'),
		concat       = require('gulp-concat'),
		cleancss     = require('gulp-clean-css'),
		autoprefixer = require('gulp-autoprefixer');

// Custom Styles
gulp.task('styles', function() {
	return gulp.src('static/sass/**/*.sass')
	.pipe(sass({
		outputStyle: 'expanded',
		includePaths: [__dirname + '/node_modules']
	}))
	.pipe(concat('styles.min.css'))
	.pipe(autoprefixer({
		grid: true,
		overrideBrowserslist: ['last 10 versions']
	}))
	.pipe(cleancss( {level: { 1: { specialComments: 0 } } })) // Optional. Comment out when debugging
	.pipe(gulp.dest('static/css'))
});

gulp.task('watch', function() {
	gulp.watch('static/sass/**/*.sass', gulp.parallel('styles'));
});

gulp.task('default', gulp.parallel('styles', 'watch'));
