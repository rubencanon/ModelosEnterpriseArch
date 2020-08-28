class Tk(Misc, Wm):
    """Toplevel widget of Tk which represents mostly the main window
    of an application. It has an associated Tcl interpreter."""
    _w = '.'
    def __init__(self, screenName=None, baseName=None, className='Tk',
                 useTk=1, sync=0, use=None):
        """Return a new Toplevel widget on screen SCREENNAME. A new Tcl interpreter will
        be created. BASENAME will be used for the identification of the profile file (see
        readprofile).
        It is constructed from sys.argv[0] without extensions if None is given. CLASSNAME
        is the name of the widget class."""
        self.master = None
        self.children = {}
        self._tkloaded = 0
        # to avoid recursions in the getattr code in case of failure, we
        # ensure that self.tk is always _something_.
        self.tk = None
        if baseName is None:
            import os
            baseName = os.path.basename(sys.argv[0])
            baseName, ext = os.path.splitext(baseName)
            if ext not in ('.py', '.pyc'):
                baseName = baseName + ext
        interactive = 0
        self.tk = _tkinter.create(screenName, baseName, className, interactive, wantobjects, useTk, sync, use)
        if useTk:
            self._loadtk()
        if not sys.flags.ignore_environment:
            # Issue #16248: Honor the -E flag to avoid code injection.
            self.readprofile(baseName, className)
    def loadtk(self):
        if not self._tkloaded:
            self.tk.loadtk()
            self._loadtk()
    def _loadtk(self):
        self._tkloaded = 1
        global _default_root
        # Version sanity checks
        tk_version = self.tk.getvar('tk_version')
        if tk_version != _tkinter.TK_VERSION:
            raise RuntimeError("tk.h version (%s) doesn't match libtk.a version (%s)"
                               % (_tkinter.TK_VERSION, tk_version))
        # Under unknown circumstances, tcl_version gets coerced to float
        tcl_version = str(self.tk.getvar('tcl_version'))
        if tcl_version != _tkinter.TCL_VERSION:
            raise RuntimeError("tcl.h version (%s) doesn't match libtcl.a version (%s)" \
                               % (_tkinter.TCL_VERSION, tcl_version))
        # Create and register the tkerror and exit commands
        # We need to inline parts of _register here, _ register
        # would register differently-named commands.
        if self._tclCommands is None:
            self._tclCommands = []
        self.tk.createcommand('tkerror', _tkerror)
        self.tk.createcommand('exit', _exit)
        self._tclCommands.append('tkerror')
        self._tclCommands.append('exit')
        if _support_default_root and not _default_root:
            _default_root = self
        self.protocol("WM_DELETE_WINDOW", self.destroy)
    def destroy(self):
        """Destroy this and all descendants widgets. This will
        end the application of this Tcl interpreter."""
        for c in list(self.children.values()): c.destroy()
        self.tk.call('destroy', self._w)
        Misc.destroy(self)
        global _default_root
        if _support_default_root and _default_root is self:
            _default_root = None
    def readprofile(self, baseName, className):
        """Internal function. It reads BASENAME.tcl and CLASSNAME.tcl into
        the Tcl Interpreter and calls exec on the contents of BASENAME.py and
        CLASSNAME.py if such a file exists in the home directory."""
        import os
        if 'HOME' in os.environ: home = os.environ['HOME']
        else: home = os.curdir
        class_tcl = os.path.join(home, '.%s.tcl' % className)
        class_py = os.path.join(home, '.%s.py' % className)
        base_tcl = os.path.join(home, '.%s.tcl' % baseName)
        base_py = os.path.join(home, '.%s.py' % baseName)
        dir = {'self': self}
        exec('from tkinter import *', dir)
        if os.path.isfile(class_tcl):
            self.tk.call('source', class_tcl)
        if os.path.isfile(class_py):
            exec(open(class_py).read(), dir)
        if os.path.isfile(base_tcl):
            self.tk.call('source', base_tcl)
        if os.path.isfile(base_py):
            exec(open(base_py).read(), dir)
    def report_callback_exception(self, exc, val, tb):
        """Report callback exception on sys.stderr.

        Applications may want to override this internal function, and
        should when sys.stderr is None."""
        import traceback
        print("Exception in Tkinter callback", file=sys.stderr)
        sys.last_type = exc
        sys.last_value = val
        sys.last_traceback = tb
        traceback.print_exception(exc, val, tb)
    def __getattr__(self, attr):
        "Delegate attribute access to the interpreter object"
        return getattr(self.tk, attr)
