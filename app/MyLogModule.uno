using Uno;
using Uno.Collections;
using Fuse;
using Fuse.Scripting;
using Fuse.Reactive;

public class MyLogModule : NativeModule
{
    public MyLogModule()
    {
        AddMember(new NativeFunction("Log", (NativeCallback)Log));
    }
    
    private static void Log(object[] args)
    {
        foreach (var arg in args)
            debug_log arg;
    }
}
